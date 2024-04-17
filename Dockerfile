FROM maven:eclipse-temurin AS build
WORKDIR /build
COPY . .
RUN --mount=type=cache,target=/root/.m2 mvn clean war:war -DskipTests

FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk17 AS final
COPY --from=build /build/target/*.war /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080
EXPOSE 9990
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-Djboss.bind.address.management=0.0.0.0", "-Djboss.bind.address=0.0.0.0"]
