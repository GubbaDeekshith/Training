FROM openjdk:17
WORKDIR target/
COPY target/dep-ser.jar /target/dep-ser.jar
EXPOSE 8083
CMD ["java","-jar","dep-ser.jar"]
