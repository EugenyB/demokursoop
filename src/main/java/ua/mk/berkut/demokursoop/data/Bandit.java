package ua.mk.berkut.demokursoop.data;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "bandit")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public Bandit(String name, String nickName, LocalDate birthday, String gang, String crimeType, Integer crimeCount) {
        this.name = name;
        this.nickName = nickName;
        this.birthday = birthday;
        this.gang = gang;
        this.crimeType = crimeType;
        this.crimeCount = crimeCount;
    }

    public Bandit(String name, String nickName, String gang, String crimeType, Integer crimeCount) {
        this.name = name;
        this.nickName = nickName;
        this.gang = gang;
        this.crimeType = crimeType;
        this.crimeCount = crimeCount;
    }

}