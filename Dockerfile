# Fáze 1: Build native image pomocí GraalVM
FROM ghcr.io/graalvm/native-image-community:21 AS builder

WORKDIR /app
COPY . .

RUN ./mvnw -Pnative -DskipTests package

# Fáze 2: Spuštění – čistý Alpine Linux, žádná JVM potřeba
FROM alpine:latest
WORKDIR /app

# Zkopíruj nativní binárku z předchozí fáze (nahraď názvem podle tvého projektu)
COPY --from=builder /app/target/tutorial /app/tutorial
RUN chmod +x /app/tutorial

ENTRYPOINT ["/app/tutorial"]
