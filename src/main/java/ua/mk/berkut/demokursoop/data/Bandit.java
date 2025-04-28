package ua.mk.berkut.demokursoop.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "bandit")
public class Bandit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String nickName;
    private LocalDate birthday;
    private String gang;
    private String crimeType;
    private Integer crimeCount;
}