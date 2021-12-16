# MultiChiefMain
<p><b>MultiChief</b> is an experimental microservice-based ERP system (implementation for construction industry).<p/>
<p><b>MultiChiefMain</b> (this project) is a set of orchestrators (project modules).
Each module is a function orchestrator (Spring based web-application) which can be deployed in web server environments (WAR file).</p>
<p>Each function orchestrator has REST API, does certain business functions, manages certain busines processes (preparing DTOs, Views, BusinessEntities, Documents, etc.)
for clients (frontend module <a href="https://github.com/LevGoryachev/MultiChiefWeb">MultiChiefWeb</a> and other apps).</p>

<p>The clients (apps) can use one or more orchestrators according to their business needs.</p>

<p>In case the business needs, more such orchestrators can be created
(not only as modules of this project, but also as like independent projects).
</p>

<p>The orchestrators use one or more core microservices (domains) to implement their functionality:</p>

<p>Currently, in MultiChief ERP are used next core microservices:</p>
<ul>
    <li><a href="https://github.com/LevGoryachev/MultiChiefConstruction">MultiChiefConstruction</a></li>
    <li><a href="https://github.com/LevGoryachev/MultiChiefInventory">MultiChiefInventory</a></li>
    <li><a href="https://github.com/LevGoryachev/ForGeo">ForGeo</a></li>
    <li><a href="https://github.com/LevGoryachev/MultiChiefWorkflow">MultiChiefWorkflow</a></li>
    <li><a href="https://github.com/LevGoryachev/MultiChiefStaff">MultiChiefStaff</a></li>
</ul>
<p>In case the functional needs, more microservices can be created</p>
<p>Summary:</p>
<ul>
    <li><p><b>Orchestrators: Java 11, Spring-Boot, Spring Security, Spring Data JPA (Hibernate), Camunda</b></p></li>
    <li><p><b>Microservices: Java 11, Spring-Boot, Spring Security, Spring Data JPA (Hibernate)</b></p></li>
    <li><p><b>Frontend: React-Next JS</b></p></li>
</ul>
<p><b>Orchestrators: Java 11, Spring-Boot, Spring Security, Spring Data JPA (Hibernate), Camunda</b></p>
<p><b>In each module:</b> deploy and follow:</p>
<p><b>API:</b> /swagger-ui/</p>
<p><b>Description:</b> /index.html</p>
<h3>Architecture</h3>
<p>Patterns: microservices, domain-driven design, choreographic orchestration, DB per service<p/>

![MultiChiefApplicationDiagram](https://user-images.githubusercontent.com/61917893/141860031-efe40b02-9a3b-4b94-aaef-622869eca3ab.jpg)

<p>Customized microservice-based domain-driven architecture has global levels:<p/>
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

<p>MultiChief (ERP). License: GNU GPL v3. Copyright (C) 2021 Lev Goryachev.</p>
