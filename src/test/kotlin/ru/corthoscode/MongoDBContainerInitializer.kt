package ru.corthoscode

import org.testcontainers.containers.MongoDBContainer

object MongoDBContainerInitializer {

    private const val IMAGE = "mongo:7.0"
    private lateinit var mongoDBContainer: MongoDBContainer

    fun initialize(): MongoDBContainer {

        if (!MongoDBContainerInitializer::mongoDBContainer.isInitialized) {
            mongoDBContainer = MongoDBContainer(IMAGE)

            mongoDBContainer.start()
            System.setProperty("MONGODB_URI", mongoDBContainer.replicaSetUrl)
        }

        return mongoDBContainer
    }
}
