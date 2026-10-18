package com.example.cicd.config;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Configuration
public class RagConfig {

    @Value("classpath:sample-policy.txt")
    private Resource policyResource;

    @Bean
    public VectorStore vectorStore(EmbeddingModel embeddingModel) {
        // SimpleVectorStore Builder ka use kar rahe hain (Milestone M6 compatibility ke liye)
        SimpleVectorStore vectorStore = SimpleVectorStore.builder(embeddingModel)
                .build();

        // Text file read karke documents list banana
        TextReader textReader = new TextReader(policyResource);
        List<Document> documents = textReader.get();

        // Vector store mein add karna (embeddings automatically generate hongi)
        vectorStore.add(documents);

        return vectorStore;
    }
}