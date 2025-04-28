package ua.mk.berkut.demokursoop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mk.berkut.demokursoop.data.Bandit;

public interface BanditRepository extends JpaRepository<Bandit, Integer> {
}