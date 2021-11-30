# MultiChiefMain
<p><b>MultiChief</b> is an experimental microservice-based ERP system for construction industry (on-line and off-line interaction between departments and employees).<p/>
<p><b>MultiChiefMain</b> is a main project which is set of orchestrators - project modules.
Each module is an orchestrator and it can be deployed in web server environments (as a WAR file) in case the business needs.</p>
<p>Each service-orchestrator is intended for certain business function and responsible for preparing data
(DTOs, Views, BusinessEntities, Documents, etc.) for web-clients (frontend module <a href="https://github.com/LevGoryachev/MultiChiefWeb">MultiChiefWeb</a> and others, that can be created). </p>
  
<p><b>Summary: Java 11, Spring-Boot, Spring Security, Spring Data JPA (Hibernate)</b></p>
<p><b>Customized docs (each module):</b> deploy the target APP and follow:</p>
<p><b>API:</b> /swagger-ui/</p>
<p><b>Description:</b> /index.html</p>
<p><b>Database diagram:</b></p>
<p><b>Javadocs:</b></p>
<h3>Architecture</h3>
<p>Customized microservice-based domain-driven architecture that has levels:<p/>
<ul>
<li><b>Core sevices (atomic microservices).</b>
 Each one is responsible for a certain functions of its domain(CRUD operations of subdomains, preparing special DTOs)
 and does not interact with both other microservices and business-consumer-services. Depending on the necessity,
 other microservices (related to MultiChief or not) can be created and added to interaction.</li>
</ul>
<ul>
<li><b>Composite/integration sevices (service-orchestrators).</b> Each one is responsible for a certain business-function.
 An orchestrator can use from one to many MultiChief microservices and also can use third-party web services to implement business-functionality. Depending on the necessity of business,
 additional MultiChief-service-orchestrators can be created and added to interaction.</li>
<li><b>Consumers (frontend module <a href="https://github.com/LevGoryachev/MultiChiefWeb">MultiChiefWeb</a>).</b>
Depending on the necessity, additional GUI modules can be added.</li>
</ul>

![MultiChiefApplicationDiagram](https://user-images.githubusercontent.com/61917893/141860031-efe40b02-9a3b-4b94-aaef-622869eca3ab.jpg)


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
<p>MultiChief (ERP). License: GNU GPL v3. Copyright (C) 2021 Lev Goryachev.</p>
