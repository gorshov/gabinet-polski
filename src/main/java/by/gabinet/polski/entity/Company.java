package by.gabinet.polski.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Александр Горшов on 25.07.2017  16:55.
 */
@Table(name = "COMPANY")
@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "COMPANY_NAME", nullable = false)
    private String name;

    @Column(name = "PHONE")
    private String companyPhone;

    @Column(name = "COMPANY_EMAIL")
    private String companyEmail;

    @Column(name = "UNP", unique = true)
    private String UNP;

    public Company() {

    }

    @Builder
    public Company(String name, String companyPhone, String companyEmail, String UNP) {
        this.name = name;
        this.companyPhone = companyPhone;
        this.companyEmail = companyEmail;
        this.UNP = UNP;
    }
}
