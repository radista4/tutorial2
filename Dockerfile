# Build fáze
FROM ghcr.io/graalvm/graalvm-ce:21.3.3 AS builder

WORKDIR /app
COPY . .

RUN gu install native-image
RUN ./mvnw -Pnative -DskipTests package

# Runtime fáze – čistá binárka bez JVM
FROM alpine:latest
WORKDIR /app

COPY --from=builder /app/target/tutorial /app/tutorial
RUN chmod +x /app/tutorial

ENTRYPOINT ["/app/tutorial"]
