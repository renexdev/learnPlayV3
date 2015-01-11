package models;

import java.util.List;
import play.libs.F.Option;

import play.data.*;
import play.data.validation.Constraints.*;
import javax.validation.Valid;

//import javax.persistence.*;

public class User{
  @Required
  public String name;

  @Required
  @Email
  public String email;

  @Required
  @Min(0)
  @Max(150)
  public Integer age;

  @Required
  public Boolean female;

  @Valid
//Valid: This one is related
//to Required but is for embedded structures. That is, if an external object has
//to be set and is also constrained by validation rules, we can ask the system
//to check its validity as part of the upper-level object validation process (it's a
//kind of a cascade on validation request).
  @Required
  
  public Address address = new Address();

  @Valid
  public List<User> friends;

  @Valid
  public Option<User> spouse;

}