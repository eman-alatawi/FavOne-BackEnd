# FavOne
Your place of your favorite  Movie/Drama/Actor. The users can add their favorite movies, dramas, actors and share them with the world. (FavOne) is the shortcut of Favorite One. nice name right? :)

## Important Links

- [FaveOne Front-End Repo](https://git.generalassemb.ly/eman-e-alatawi/FaveOne-FrontEnd)
- [Deployed FaveOne API](www.link.com)
- [Deployed FaveOne React App](www.link.com)


## Planning Story
From Day-1 start choosing the idea and decide the name, design the ERD, Wireframes and create the Apps, Repos. Continue by creating one Model/Controller in the back-end and check it with the Postman then go and design the related components in the front-end. For each 2 days there is a complete feature in the front-end with design and styles and the back-end functionality.

### Technologies Used

- Java
- Spring Boot
- Spring Security
- JPA
- JWT Authentication (JSON Web Token)
- MySQL Driver
- Eclipse
- MySQL Workbench
- sqlDBM to design ER diagram
- GitHub
- AWS RDS
- AWS EB


### Catalog of Routes

Verb         |	URI Pattern   |	Description
------------ | -------------  | ------------- 
GET | /actor/index | Retrieve all Actors
GET | /actor/detail/:id | Retrieve the details of specific Actor
POST | /actor/add | Add new Actor
PUT | /actor/edit | Update Actor
DELETE| /actor/delete/:id | Delete Actor
GET | /md/index | Retrieve all Movies-Dramas
GET | /md/detail/:id | Retrieve the details of specific Movie-Drama
POST | /md/add | Add new Movie-Drama
PUT | /md/edit | Update Movie-Drama
DELETE | /md/delete/:id | Delete Movie-Drama
GET | /mdgender/index | Retrieve all Movie-Drama's Genders
GET | /mdgender/detail/:id | Retrieve the details of specific Movie-Drama's Gender
POST | /mdgender/add | Add new Movie-Drama's Gender
PUT | /mdgender/edit | Update Movie-Drama's Gender
DELETE | /mdgender/delete/:id | Delete Movie-Drama's Gender
GET | /episode/index | Retrieve all Movie-Drama's Episodes
GET | /episode/detail/:id | Retrieve the details of specific Movie-Drama's Episode
POST | /episode/add | Add new Movie-Drama's Episode
PUT | /episode/edit | Update Movie-Drama's Episode
DELETE | /episode/delete/:id | Delete Movie-Drama's Episode
GET | /imagegallery/index| Retrieve all Movie-Drama's Image Galleries
GET | /imagegallery/detail/:id | Retrieve the details of specific Movie-Drama's Image Gallery
POST | /imagegallery/add | Add new Movie-Drama's Image Gallery
PUT | /imagegallery/edit | Update Movie-Drama's Image Gallery
DELETE | /imagegallery/delete/:id | Delete Movie-Drama's Image Gallery


#### ERD:
![ERD](https://i.ibb.co/9b220pL/ER-LASTLAST-24-02-2021.png)