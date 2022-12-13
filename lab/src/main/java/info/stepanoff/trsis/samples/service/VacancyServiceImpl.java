/*
 * this code is available under GNU GPL v3
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 */

package info.stepanoff.trsis.samples.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.stepanoff.trsis.samples.db.dao.VacancyRepository;
import info.stepanoff.trsis.samples.db.model.Vacancy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VacancyServiceImpl implements VacancyService {
    

    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    public Iterable<Vacancy> listAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        vacancyRepository.deleteById(id);
    }

    @Override
    public Vacancy add(Integer number, String name) {
        return vacancyRepository.save(new Vacancy(number, name));
    }

    @Override
    public Vacancy findByNumber(Integer number) {
        return vacancyRepository.findByNumber(number);
    }
}
