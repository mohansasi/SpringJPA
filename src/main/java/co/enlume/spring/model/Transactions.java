package co.enlume.spring.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(name="TRANS_ID_GENERATOR", sequenceName="TRANS_SEQ", allocationSize=201800)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANS_ID_GENERATOR")
	public BigInteger transactionId;
	public String firstName;
	public String lastName;
	public String authCode;
	public String ahFiName;
	public String fiName;
	public BigDecimal transactionAmount;
	public String transactionDescription;
	public String transactingEntityName;
	public String transactionTime;
	public String transactionType;
	public String countryPhoneCode;
	public String phoneNumber;
	public Integer accountTypeId;
	public BigDecimal tip;
	public String transactingEntityId;
	public String issuerId;
	
	public BigInteger getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAhFiName() {
		return ahFiName;
	}
	public void setAhFiName(String ahFiName) {
		this.ahFiName = ahFiName;
	}
	public String getFiName() {
		return fiName;
	}
	public void setFiName(String fiName) {
		this.fiName = fiName;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public String getTransactingEntityName() {
		return transactingEntityName;
	}
	public void setTransactingEntityName(String transactingEntityName) {
		this.transactingEntityName = transactingEntityName;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getCountryPhoneCode() {
		return countryPhoneCode;
	}
	public void setCountryPhoneCode(String countryPhoneCode) {
		this.countryPhoneCode = countryPhoneCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public BigDecimal getTip() {
		return tip;
	}
	public void setTip(BigDecimal tip) {
		this.tip = tip;
	}
	public String getTransactingEntityId() {
		return transactingEntityId;
	}
	public void setTransactingEntityId(String transactingEntityId) {
		this.transactingEntityId = transactingEntityId;
	}
	public String getIssuerId() {
		return issuerId;
	}
	public void setIssuerId(String issuerId) {
		this.issuerId = issuerId;
	}
}
