# Usa a imagem oficial do OpenJDK
FROM openjdk:21-jdk

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado para o container
COPY target/*.jar app.jar

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]
