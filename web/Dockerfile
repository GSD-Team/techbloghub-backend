FROM amazoncorretto:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul \
    SPRING_PROFILES_ACTIVE=$SPRING_PROFILES_ACTIVE
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar