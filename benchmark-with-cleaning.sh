#!/bin/bash

echo "=== FULL CLEAN BENCHMARK ==="

# Flapdoodle - ЧИСТЫЙ старт (без кэша бинарников)
echo "1. Flapdoodle cleaning cache..."
rm -rf ~/.embedmongo/

echo "2. Flapdoodle test..."
./gradlew test --tests "ru.corthoscode.Flapdoodle_CustomerRepositoryTest" --profile
mv build/reports/profile/profile-*.html build/reports/profile/flapdoodle-profile.html 2>/dev/null || true

echo "===================================="

# Testcontainers - ЧИСТЫЙ старт (без Docker кэша)
echo "1. Testcontainers cleaning cache..."
# Остановить и удалить все запущенные контейнеры (опционально)
docker stop $(docker ps -aq) 2>/dev/null || true
# Удалить контейнер с определённым именем (если есть)
docker rm spring-mongodb-benchmark-embeded-vs-containers 2>/dev/null || true
# Удалить все образы, содержащие "mongo"
docker rmi $(docker images -q mongo:*) 2>/dev/null || true
# Удалить неиспользуемые образы (опционально, для чистоты)
docker image prune -f 2>/dev/null || true
# Удалить кеш Testcontainers
rm -rf ~/.testcontainers/

echo "2. Testcontainers test..."
./gradlew test --tests "ru.corthoscode.Testcontainers_CustomerRepositoryTest" --profile
mv build/reports/profile/profile-*.html build/reports/profile/testcontainers-profile.html 2>/dev/null || true

echo "=== BENCHMARK COMPLETE ==="