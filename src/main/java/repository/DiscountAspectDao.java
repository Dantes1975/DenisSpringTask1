package repository;

import bean.DiscountCounter;
import bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountAspectDao extends CrudRepository<DiscountCounter, Long> {

    DiscountCounter getByUser(User user);

    @Query("select d.birthdayStrategy from DiscountCounter d where d.user=:user")
    int getDiscountBirthday(@Param("user") User user);

    @Query("select d.everyTenthTicket from DiscountCounter d where d.user=:user")
    int getDiscountTenthTicket(@Param("user") User user);
}
