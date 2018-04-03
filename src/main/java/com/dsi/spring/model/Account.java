package com.dsi.spring.model;

import com.dsi.spring.validations.PSCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Account {
    @NotNull
    private Integer accountNo;

    @NotNull
    @Size(min=2, max=15, message = "length must be in 2 to 15 chars")
    @Pattern(regexp = "[A-Za-z(\\s)]+", message = "Invalid Name")
    private String accountHolderName;

    @NotNull(message = "Balance Amount is required")
    @Min(value=5000, message = "Cannot be less than 5000")
    private Integer balance;

    @NotEmpty(message = "Account type cannot be blank")
    private String accountType;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Past(message = "Account cannot be created for unborn person")
    @NotNull(message = "Date of Birth cannot be blank")
    private Date dateOfBirth;

    @NotEmpty(message = "PS code is required")
    @PSCode(value = "PSUSA", message = "Security code should start with PSUSA")
    private String psCode;

    public Account() {
    }

    public Account(Integer accountNo, String accountHolderName, Integer balance) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPsCode() {
        return psCode;
    }

    public void setPsCode(String psCode) {
        this.psCode = psCode;
    }
}
