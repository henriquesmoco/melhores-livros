#Melhores Livros

####Vote no seu livro preferido!
Neste desafio [TIDEXA](http://tidexa.com) você cria uma eleição e todo mundo vota nos seus livros preferidos.
O ranking é calculado com o [método de Schulze](http://en.wikipedia.org/wiki/Schulze_method) e pode ser acessado
à qualquer momento.

A idéia é fazer um showcase de tecnologias e a integração entre elas sem esquecer de
[ALM](http://en.wikipedia.org/wiki/Application_lifecycle_management).

#### Premissas
 * Testes, TDD, BDD, you name it;
 * Sempre atualizado para última versão das tecnologias utilizadas (não necessariamente beta, rc, etc);
 * Simplicidade, qualidade, performance;
 * Clean code;
 * ALM love.

#### Tecnologias utilizadas até agora
 * Maven 3.2.3
 * Spring MVC 4.1.2
 * Tiles 3.0.5
 * Hibernate 4.3.7
 * HSQLDB 2.3.2
 * Selenium Chrome WebDriver 2.44.0
 * Jetty 9.2.5.v20141112
 * Jetty Runner 7.5.4.v20111024

#### Configurações adicionais
##### Maven
> Dependendo da sua IDE, você pode precisar baixar e/ou configurar o [Maven](http://maven.apache.org/).

##### Variáveis de ambiente
> Para os testes de integração rodarem com o [Selenium Chrome WebDriver](https://sites.google.com/a/chromium.org/chromedriver/) é necessário configurar a variávei abaixo:<br/>
> **webdriver.chrome.driver** = c:\path_to\chromedriver.exe
