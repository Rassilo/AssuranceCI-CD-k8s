# Use CentOS 7 as the base image
FROM centos:7

# Update system and install Java and Maven
RUN yum update -y && \
    yum install -y java-17-openjdk maven && \
    yum clean all

# Set the working directory
WORKDIR /var/lib/jenkins/workspace/VMTesting

# Copy your project files into the container
COPY . ${WORKDIR}

# Build your project
RUN mvn clean install

# Define the command to run your project (modify this to match your project's startup command)
CMD ["java", "-jar", "your-application.jar"]
