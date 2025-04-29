package ua.mk.berkut.demokursoop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mk.berkut.demokursoop.data.Bandit;
import ua.mk.berkut.demokursoop.repository.BanditRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BanditService {
    private final BanditRepository banditRepository;

    public List<Bandit> findAll() {
        return banditRepository.findAll();
    }

    public Optional<Bandit> findById(Integer integer) {
        return banditRepository.findById(integer);
    }

    public Bandit save(Bandit entity) {
        return banditRepository.save(entity);
    }

    public void deleteById(Integer integer) {
        banditRepository.deleteById(integer);
    }

    public void edit(Bandit bandit) {
        banditRepository.findById(bandit.getId()).ifPresent(b -> {
            b.setName(bandit.getName());
            b.setNickName(bandit.getNickName());
            b.setBirthday(bandit.getBirthday());
            b.setGang(bandit.getGang());
            b.setCrimeCount(bandit.getCrimeCount());
            b.setCrimeType(bandit.getCrimeType());
            banditRepository.save(b);
        });
    }
}
