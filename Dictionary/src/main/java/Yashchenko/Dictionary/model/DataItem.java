package Yashchenko.Dictionary.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class DataItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "dictionary_id", nullable = false)
    private DictionaryItem dictionary;

    private String code;
    private String value;

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DictionaryItem getDictionary() {
        return dictionary;
    }

    public void setDictionary(DictionaryItem dictionary) {
        this.dictionary = dictionary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}