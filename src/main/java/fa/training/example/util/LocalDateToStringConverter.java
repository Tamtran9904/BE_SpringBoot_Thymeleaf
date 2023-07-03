package fa.training.example.util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.modelmapper.AbstractConverter;

public class LocalDateToStringConverter extends AbstractConverter<LocalDate, String> {

  private final DateTimeFormatter dateFormat;

  public LocalDateToStringConverter(String formater) {
    this.dateFormat = DateTimeFormatter.ofPattern(formater);
  }

  @Override
  protected String convert(LocalDate localDate) {
    return localDate.format(dateFormat);
  }
}
