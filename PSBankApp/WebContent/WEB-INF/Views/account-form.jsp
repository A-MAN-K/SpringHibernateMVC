<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="lbl.title"/></title>
<style>
	.error{
		color:red
		}

</style>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
		
			<div class="row">
				<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
					<h2 class="page-header">Please Fill Up the Form Details</h2>					
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<form:form action="saveAccount" modelAttribute="account"
						cssClass="form-horizontal" role="form">
						
							<div class="form-group row">
								<Label for="accountNo" class="col-6 col-form-label">Account No:</Label>
								<div class="col-6">
									<form:input path="accountNo" cssClass="form-control"/>
									<form:errors path="accountNo" cssClass="alert-danger"/>
									<text class="alert-danger">${message} </text>
								</div>
							</div>
							
							<div class="form-group row">
								<Label for="accountHolderName" class="col-6 col-form-label">Account Holder Name:</Label>
								<div class="col-6">
									<form:input path="accountHolderName" cssClass="form-control"/>
									<form:errors path="accountHolderName" cssClass="alert-danger"/>
								</div>
							</div>
							
							<div class="form-group row">
								<Label for="balance" class="col-6 col-form-label">Balance:</Label>
								<div class="col-6">
									<form:input path="balance" cssClass="form-control"/>
									<form:errors path="balance" cssClass="alert-danger"/>
								</div>
							</div>
														
							<div class="form-group row">
								<Label for="accountType" class="col-6 col-form-label">Account Type:</Label>
								<div class="col-6">
									<form:select path="accountType" cssClass="form-control">
										<form:option value="">Select Account Type</form:option>
										<form:option value="SAVINGS">Savings</form:option>
										<form:option value="CURRENT">Current</form:option>
									</form:select>
									<form:errors path="accountType" cssClass="alert-danger"/>
								</div>
							</div>
							
							<div class="form-group row">
								<Label for="dob" class="col-6 col-form-label">Date Of Birth:</Label>
								<div class="col-6">
									<form:input path="dateOfBirth" cssClass="form-control"/>
									<form:errors path="dateOfBirth" cssClass="alert-danger"/>
								</div>
							</div>
							
							<div class="form-group row">
								<Label for="psCode" class="col-6 col-form-label">PS Code:</Label>
								<div class="col-6">
									<form:input path="psCode" cssClass="form-control"/>
									<form:errors path="psCode" cssClass="alert-danger"/>
								</div>
							</div>
							
							<div class="form-group-row">
								<div class="offset-6 col-6">
									<input type="submit" value="Save Account" name="btnSubmit"
										class="btn btn-primary" />
								</div>
							</div>
							
					</form:form>
				</div>
			</div>
		
		<%@ include file="footer.jsp" %>
	</div>

<!--  
	<h2>Please Fill Up the Form Details</h2>
	<form:form action="saveAccount" modelAttribute="account">
		<table>
			<tr>
				<td><spring:message code="lbl.accountNo"/>: </td>
				<td>
					<form:input path="accountNo" size="30"/>
					<form:errors path="accountNo" cssClass="error" />
					<b><font color="red">${message}</font></b>
				</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.accountHolderName"/>: </td>
				<td>
					<form:input  path="accountHolderName" size="30"/>
					<form:errors path="accountHolderName" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.balance"/>: </td>
				<td>
					<form:input  path="balance" size="30"/>
					<form:errors path="balance" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.accountType"/>: </td>
				<td>
					<form:select  path="accountType">
					<form:option value="">Select Account Type</form:option>
					<form:option value="SAVINGS">Savings </form:option>
					<form:option value="CURRENT">Current </form:option>
					</form:select>				
					<form:errors path="accountType" cssClass="error"/>
					</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.dob"/>: </td>
				<td>
					<form:input  path="dateOfBirth" size="30"/>
					<form:errors path="dateOfBirth" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td><spring:message code="lbl.psCode"/>: </td>
				<td>
					<form:input  path="psCode" size="30"/>
					<form:errors path="psCode" cssClass="error"/>
				</td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Save Account" name="btnSubmit">
			</tr>
		</table>
	</form:form>
	
	-->
</body>
</html>