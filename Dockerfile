# First stage: Use CentOS 7 to get Maven
FROM docker.io/library/centos:7 AS MAVEN_BUILD

# Install dependencies for downloading Maven
RUN yum install -y wget

# Download and set up Maven
ENV MAVEN_VERSION 3.9.5
RUN wget https://downloads.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.tar.gz -P /tmp && \
    tar xf /tmp/apache-maven-*.tar.gz -C /opt && \
    ln -s /opt/apache-maven-$MAVEN_VERSION /opt/maven && \
    rm -f /tmp/apache-maven-*.tar.gz

# Set environment variables for Maven
ENV MAVEN_HOME /opt/apache-maven-3.9.5
ENV PATH ${MAVEN_HOME}/bin:${PATH}

# Second stage: Use OpenJDK 17 image
FROM openjdk:21-jdk

# Set environment variables for Maven (in the second stage)
ENV MAVEN_HOME /opt/apache-maven-3.9.5
ENV PATH ${MAVEN_HOME}/bin:${PATH}

# Copy Maven from the first stage
COPY --from=MAVEN_BUILD /opt/apache-maven-3.9.5 /opt/apache-maven-3.9.5

# Copy your project files into the container
COPY . /var/lib/jenkins/workspace/PFE
WORKDIR /var/lib/jenkins/workspace/PFE

# Define the command to run your project (modify this to match your project's startup command)
CMD ["java", "-jar", "target/Assurance-0.0.1-SNAPSHOT.jar"]
