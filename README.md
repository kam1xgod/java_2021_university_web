<br/>
<p align="center">
  <a href="https://github.com/kam1xgod/java_2021_university_web">
    <img src="https://i.pinimg.com/564x/c9/21/0a/c9210a080958f0422b5890871ab1a9fd.jpg" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Java Web Course.</h3>

  <p align="center">
    основы/basics of xml, html + css + js, rmi, jdbc, ejb, jpa.
    <br/>
    <br/>
    <a href="https://github.com/kam1xgod/java_2021_university_web/issues">Report Bug</a>
    .
  </p>
</p>

## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)

## About The Project

#### RU.
В этом репозитории собраны лабораторные работы по курсу прикладного программирования, нацеленного на изучение основ web-разработки на языке программирования Java.

#### EN.
In this repository I stored my university projects from applied programming course aimed on learning basics of web development with Java.

## Built With

* IDE — Intellij IDEA Ultimate 2021.2.1 or NetBeans 12.5;
* OS — Windows 10, 64-bit;
* Servers (? idk) — Tomcat 10.0.12, Wildfly 25.0.1;

#### RU.
IDEA: создавался проект для java enterprise, веб-приложение под maven. возможно, где-то придётся выбирать jakarta 9, вместо javaee 8. зависимости для проекта, которые выбирались при создании: EJB, JPA, Servlets (обычно выбраны по дефолту).
Wildfile: я делал бэкап стандартного standalone.xml и заменил его на файл standalone-full.xml. просто переименуйте его.
Tomcat работал из коробки, но на последних лабораторных отказывался запускаться.

#### EN.
IDEA: project was created for java enterprise, web-application, build system maven. may be it would be better for you to choose jakarta 9 instead of javaee 8. dependecies choosen while creation: EJB, JPA and Servlets (by default).
Wildfly: I made a backup of original standalone.xml file and replaced it with standalone-full.xml. Just rename it after backup.
Tomcat worked pretty well by default but doesn't startup on last labs.

## Tasks.

### №1.
##### Задание 1
Изучить предлагаемый файл описания типа документа сформировать документ согласно этим правилам.
```
--- group.dtd ----------------------------------------------------
<?xml version="1.0" encoding="UTF-8" ?>

<!ELEMENT group (student*)>

<!ELEMENT student (subject*,average?)>
<!ATTLIST student
 firstname CDATA #REQUIRED
 lastname CDATA #REQUIRED
 groupnumber CDATA #REQUIRED
>

<!ELEMENT subject EMPTY>
<!ATTLIST subject
 title CDATA #REQUIRED
 mark (1|2|3|4|5) #REQUIRED
>
<!ELEMENT average (#PCDATA)>
------------------------------------------------------------------
```
##### Задание 2
Разработать на Java консольное приложение, в котором задать имена входного и выходного XML-файлов. Задача приложения заключается в проверке значения средней оценки и его коррекции, если в исходном документе оно не соответствует действительности.
Для выполнения задания можно использовать SAX, DOM или JAXB. 

SAX — Simple API for XML. может прочесть файл, была попытка перезаписывать файл вручную, но я сдался. использовал DOM, но оставил SAX. 
DOM — Document Object Module. из-за того, что парсит весь файл сразу, а не потоково, как это делает SAX, может делать всё.
JAXB — Java Architecture for XML Binding. Даже не прикасался к этому. Возможно, зря.

### №2
##### Задание 1
Создать страницу HTML, на которой располагается HTML-форма, содержащая следующие элементы.
•	Текстовое поле для ввода номера сотрудника (для дальнейшего поиска по этому номеру в базе данных).
•	Кнопка, подтверждающая ввод номера сотрудника (для дальнейшей отправки введенных данных на сервер).
•	Текстовое поле для ввода имени сотрудника (для дальнейшего поиска по этому имени в базе данных).
•	Кнопка, подтверждающая ввод имени сотрудника (для дальнейшей отправки введенных данных на сервер).
•	Кнопка для вывода информации обо всех сотрудниках.
•	Гиперссылка для вывода веб-страницы создания нового сотрудника.
•	Таблица, включающая следующие поля и элементы соответственно:
o	<Поле без имени> / checkbox (указывает, выбрана ли текущая строка таблицы);
o	номер сотрудника / гиперссылка с текстом номера сотрудника;
o	имя сотрудника / соответствующий текст;
o	должность сотрудника / соответствующий текст;
o	дата принятия на работу / соответствующий текст;
o	департамент / соответствующий текст;
o	“Удалить” / гиперссылка для удаления сотрудников.
Заполнить таблицу произвольными данными о сотрудниках (не менее 10 позиций).

##### Задание 2
К реализованной ранее странице подключить файл каскадных таблиц стилей CSS, с помощью которого возможно изменение стиля любого из элементов отображения в форме, а также имеющейся таблицы.
  
### №3
##### Задание 1
Для текстового поля ввода имени сотрудника создайте скрипт, выводящий в поле ввода надпись «например, Иванов». При получении полем ввода фокуса (установка курсора) надпись должна исчезать, а при потере фокуса – появляться.
  
##### Задание 2
Для текстового поля ввода и кнопки подтверждения ввода номера создайте скрипт, проверяющий, является ли введенная последовательность числом. Если введенная последовательность символов не является числом, необходимо выводить сообщение о необходимости ввода числа и кнопкой «Ок» закрытия сообщения. Для выполнения задания можно воспользоваться регулярными выражениями, или функциями parseInt() и isNaN().
  
##### Задание 3
Для гиперссылки удаления информации о сотруднике в таблице на странице создайте скрипт вывода окна подтверждения удаления с двумя кнопками «Удалить» и «Отмена». При нажатии кнопки «Удалить» необходимо скрывать соответствующую строку в таблице.
  
##### Задание 4
Создайте дополнительную HTML-страницу, содержащую текстовое поле ввода для отображения фамилии сотрудника и кнопку «Сохранить». Для главной страницы из предыдущего занятия создайте скрипт, который по нажатию кнопки (подтверждения ввода фамилии сотрудника) передает введенную фамилию в текстовое поле новой созданной страницы. 
создайте скрипт, который по нажатию кнопки (подтверждения ввода фамилии сотрудника) передает введенную фамилию в текстовое поле новой созданной страницы. 

### №4.
##### Задание 1
Написать сериализуемый класс Task, хранящий параметры некоторого математического действия (два операнда и константу, описывающую действие).

##### Задание 2
Написать серверное RMI-приложение (т.е. написать класс сервера, серверного объекта, его интерфейс и пр.), реализующее сервис вычисления математических операций (для передаваемых объектов типа Task).

##### Задание 3
Написать консольное приложение, получающее доступ к удаленному объекту и выполняющее на нем действия, вводимые пользователем с клавиатуры.

##### ВНИМАНИЕ
В ходе выполнения задания НАСТОЯТЕЛЬНО рекомендуется придерживаться стандарта JavaSE 1.5 и новых возможностей технологии RMI (см. руководство к действию http://download.oracle.com/javase/6/docs/technotes/guides/rmi/hello/hello-world.html).

### №5.
##### Задание 1
Написать оконное приложение, работающее с базой данных, использовавшейся в заданиях курса по БД (служащие, подразделения, категории).
Вывести на экран информацию обо всех сотрудниках (номер, имя, менеджер, зарплата, номер подразделения, название подразделения, город нахождения отдела, разряд ЕТС).
По вводимому пользователем идентификатору работника следует вывести сведения о работнике, включая его место работы, название подразделения и т.д.
Приложение не должно закрываться по окончании выполнения запроса, начало выполнения запроса должно происходить по нажатию кнопки.
В случае возникновения ошибок пользователь должен получать сообщения об ошибке.
Для получения соединения можно использовать класс DriverManager.

##### Задание 2
Добавить возможность добавления и удаления работников. 

### №6.
##### Задание 1
Создать простое Web-приложение, состоящее из страницы index.html и файла hello.png.
В качестве Web-сервера и Application-сервера можно воспользоваться сервером GlassFish (поставляется вместе с NetBeans и предлагается по умолчанию).
Файл hello.png может быть создан, например, с помощью «графического редактора» Paint и может содержать любой «осмысленный» рисунок (например, надпись «Hello world!»).
Файл index.html создается средствами NetBeans и должен содержать текстовое приветствие (Hello World!) в виде заголовка первого уровня, пять копий изображения из файла hello.png, разделенных разрывами строки, а также надпись «Click here to download hello-world picture», где слово here должно быть ссылкой на файл hello.png.
Рекомендуется удалить из проекта файл index.jsp и изменить welcome-file в дескрипторе развертывания web.xml.
Запустите приложение, просмотрите результат в браузере. Попробуйте скачать файл, кликнув по ссылке.

##### Задание 2
Создайте сервлет, формирующий графический файл и привязанный к URL “/hello.png” (сам файл с этим названием удалите из проекта). Тип отклика сервлета должен быть “image/png”.
Настройте соответствующим образом дескриптор развертывания (либо аннотируйте класс сервлета).
Изображение (640х120) должно содержать надпись “Hello World!”, написанную шрифтом Arial (bold, 72pt) на координатах (100, 100). Цвет надписи должен быть случайным (полученным с помощью случайных величин).
Классы, которые потребуются для создания изображения:
java.awt.Color (описывает цвет графического примитива);
java.awt.Font (описывает шрифт);
java.awt.Graphics (канва для рисования, в т.ч. содержит метод drawString);
java.awt.image.BufferedImage (изображение, размер и тип задаются в конструкторе, тип определяется одной из констант класса);
javax.imageio.ImageIO (содержит статические методы ввода и вывода изображений, в т.ч. в байтовые потоки);
java.util.Random (генератор псевдослучайных чисел, содержит в т.ч. метод nextInt(256)).
Запустите приложение, просмотрите результат в браузере. Попробуйте скачать файл, кликнув по ссылке.
Попробуйте скачать файл повторно и сравните результат. Попробуйте также несколько раз обновить страницу в браузере.
Исследуйте структуру war-файла, формируемого для выкладки на сервер.

### №7.
##### Задание 1
Написать простое web-приложение, основанное на технологии JSP и реализующее простой калькулятор. В состав приложения должно входить две jsp-страницы.
Первая страница должна выводить форму, содержащую два текстовых поля ввода для чисел, а также 4 кнопки с арифметическими операциями. По нажатию на одну из кнопок должна выводиться эта же страница, только в нижней ее части следует вывести выполненную операцию и ее результат (например, “4 * 4 = 16”). При этом в полях ввода должны сохраняться прежние значения.
Вторая страница должна служить сообщением об ошибке и предоставлять возможность перехода на исходную страницу.

##### Задание 2
Написать web-приложение для работы с базой сотрудников. Приложение должно обеспечивать следующую функциональность:
· поиск и выведение данных о сотруднике по его номеру;
· поиск и выведение данных о сотрудниках по имени;
· вывод информации обо всех сотрудниках;
Получение соединения должно производиться через DataSource, настроенный на сервере.
При выполнении задания следует пользоваться результатами, полученными при выполнении выполненных ранее заданий по HTML&CSS, JavaScript и JDBC.
Приложение должно содержать страницу для вывода сообщений об ошибках.

### №8.
##### Задание 1
Создать Enterprise-приложение, состоящее из одного EJB-модуля и одного WAR-модуля.

##### Задание 2
Написать сессионный компонент, реализующий работу калькулятора.
Калькулятор должен иметь 4 регистра памяти: 2 операнда, текущий результат и «память».
Также должны быть доступны: 4 арифметических действия, операция сохранения текущего результата в память, операции извлечения значения из памяти в каждый из операндов, а также сброс значения в памяти.
Компонент должен быть включен в EJB-модуль.

##### Задание 3
Написать Web-приложение (в виде web-модуля), предоставляющее web-интерфейс на основе jsp-страниц для работы с калькулятором.
На форме должны быть поля ввода для значений регистров, значение результата (если оно доступно), текущее состояние памяти калькулятора, а также кнопки для выполнения всех описанных в задании 2 операций.
В случае возникновения ошибок следует выводить корректное сообщение об ошибке.
Приложение должно быть представлено в виде WAR-модуля.

##### Задание 4
Отладить и проверить работу Enterprise-приложения.

##### Задание 5
В разработанном ранее приложении для работы с данными о сотрудниках предприятия следует переместить всю работу с базой данных в SessionBean, а из JSP-страниц и сервлетов следует обращаться только к сессионному компоненту.

### №9.
##### Задание 1
Написать сущностный компонент для использовавшейся ранее таблицы работников (в стиле BMP), предназначенный только для считывания данных из таблицы (методы сохранения, создания и удаления можно не реализовывать).
В компоненте реализовать метод поиска сотрудников по имени.

##### Задание 2
К написанному ранее приложению (JSP + Session Beans), выводящему информацию о сотрудниках организации, добавить следующую функциональность.
Модифицировать код так, чтобы работа с информацией о сотрудниках осуществлялась через экземпляры сущностного компонента.

### №10. НЕ РАБОТАЕТ, ПОТОМУ ЧТО Я КЛОУН. ФИКСАНУТЬ ТАК И НЕ СМОГ.
##### Задание 1
Сконфигурировать через администраторскую консоль сервера фабрику соединений JMS и объект очереди JMS.

##### Задание 2
Создать таблицу в базе данных, в которой сохраняется строка сообщения и время его прихода.

##### Задание 3
Описать MDB-компонент, принимающий сообщения. Если сообщение является текстовым, то его данные должны быть внесены в базу данных.
Если сообщение не является текстовым, то вместо текста сообщения следует записать «Wrong message type!»

##### Задание 4
Написать jsp-страницу, выводящую приглашение, а также поле ввода и кнопку отправки сообщения. По нажатию кнопки сообщение должно отправляться в очередь, к которой присоединен MDB-компонент.
Объекты соединений и т.д., полученные однажды, рекомендуется хранить как параметры сессии.

##### Задание 5
Написать jsp-страницу, выводящую список полученных сообщений в заданном временном диапазоне.
