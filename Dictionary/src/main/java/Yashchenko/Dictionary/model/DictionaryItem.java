package Yashchenko.Dictionary.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Table(name = "dictionary")
public class DictionaryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private UUID id;
    private String code;
    private String description;
}
