# Flapdoodle
./gradlew test --tests "ru.corthoscode.Flapdoodle_CustomerRepositoryTest" --profile
mv build/reports/profile/profile-*.html build/reports/profile/flapdoodle-profile.html


# Testcontainers
./gradlew test --tests "ru.corthoscode.Testcontainers_CustomerRepositoryTest" --profile
mv build/reports/profile/profile-*.html build/reports/profile/testcontainers-profile.html