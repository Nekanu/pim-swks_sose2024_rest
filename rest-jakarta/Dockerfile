FROM maven:eclipse-temurin AS build
WORKDIR /build
COPY . .
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk17 AS final
COPY --from=build /build/rest-jakarta/target/rest-jakarta*.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-Djboss.bind.address.management=0.0.0.0", "-Djboss.bind.address=0.0.0.0"]
