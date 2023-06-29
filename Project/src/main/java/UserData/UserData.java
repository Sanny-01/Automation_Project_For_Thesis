package UserData;

import com.github.javafaker.Faker;

import static com.google.common.base.Ascii.toLowerCase;

public class UserData {
    public String firstName, lastName, phone, password, address, email, country, state, city, zip;

    public void setUserCredentials() {
        Faker faker = new Faker();

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        phone = faker.phoneNumber().cellPhone();
        password = "password";
        address = faker.address().streetAddress();
        email = toLowerCase(firstName) + "." + toLowerCase(lastName) + "@mail.com";
        country = "Georgia";
        state = "Tbilisi";
        city = "Tbilisi";
        zip = "0153";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }
}
