# MultiChiefMain
MultiChiefMain is a main RESTful service of MultiChief - the experimental ERP system for construction industry. 
MultiChiefMain is responsible for preparing data (DTO) for web-clients (frontend modules <a href="https://github.com/LevGoryachev/MultiChiefWeb">MultiChiefWeb</a>). 
<p>Generally, MultiChief web-app is intended for on-line and off-line interaction between departments and employees.</p>
<p><b>Summary: Java 11, Spring-Boot, Spring Security, Spring Data JPA (Hibernate)</b></p>
<p><b>DB: relational database with stored procedures(PostgreSQL)</b></p>


<p>Database structure in files:</p>
<ul>
<li><b>MultiChiefMain_DB_v1_1.sql</b></li>
</ul>



<h3>Database scheme</h3>

![MultiChiefMain_DB_v1_1](https://user-images.githubusercontent.com/61917893/134715499-16ee0f1b-002a-41cd-b2cb-32c4c2033ec4.jpg)

<p>Descriptions:</p>

<p>1. Bind-tables are for IDs of other domain roots (which other microservices can store):</p>
<p>bind_department (PK), bind_order (employee_id) - MultiChiefStaff</p>
<p>bind_warehouse (PK), bind_bom (PK) (bill of materials), bind_order (PK) - MultiChiefMRP</p>
<p>bind_bim (PK) (building information models), bind_estimate (PK) - MultiChiefBIM</p>
<p>bind_bow (PK) - MultiChiefWorkflow</p>
<p>contract_id field - MultiChiefDocflow</p>

<p>2. Company_project - invest_project_id can be null (in case a company-user is not an owner and does not have investment projects)</p>
<p>Free software for educational purposes. Author: Lev Goryachev.</p>
