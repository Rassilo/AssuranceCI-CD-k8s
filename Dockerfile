# Use CentOS 7 as the base image
FROM docker.io/library/centos:7

# Update system and install Java
RUN yum update -y && \
    yum install -y java-17-openjdk && \
    yum clean all

# Install dependencies for downloading Maven
RUN yum install -y wget

# Download and set up Maven
ENV MAVEN_VERSION 3.8.3
RUN wget https://downloads.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz -P /tmp && \
    tar xf /tmp/apache-maven-*.tar.gz -C /opt && \
    ln -s /opt/apache-maven-$MAVEN_VERSION /opt/maven && \
    rm -f /tmp/apache-maven-*.tar.gz

# Set environment variables for Maven
ENV MAVEN_HOME /opt/maven
ENV PATH ${MAVEN_HOME}/bin:${PATH}

# Copy your project files into the container
COPY . /var/lib/jenkins/workspace/VMTesting
WORKDIR /var/lib/jenkins/workspace/VMTesting

# Build your project
RUN mvn clean install

# Define the command to run your project (modify this to match your project's startup command)
CMD ["your-startup-command"]
