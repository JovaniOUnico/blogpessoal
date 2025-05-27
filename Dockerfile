# Etapa 1: Build da aplicação
FROM maven:3.9.0-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar arquivos de configuração do Maven
COPY pom.xml .
COPY .mvn/ .mvn/

# Baixar dependências sem compilar o código
RUN mvn dependency:go-offline

# Copiar o restante do código
COPY src/ ./src/

# Compilar e empacotar a aplicação
RUN mvn clean package -DskipTests

# Etapa 2: Imagem para execução
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar o JAR gerado na etapa de build
COPY --from=build /app/target/blogpessoal-*.jar /app/app.jar

# Expor a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]