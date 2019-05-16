package service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

@WebService
public class HolidayServiceImpl implements HolidayService {
    @WebMethod
    public Long countDaysToHolidays() {
        LocalDate currentDate = LocalDate.now();
        LocalDate holidayStart = LocalDate.of(2019, Month.JULY, 1);
        return ChronoUnit.DAYS.between(currentDate, holidayStart);
    }
}
