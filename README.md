# Backend Mapping Challenge

### I used:
- Java 21
- Maven 3.9
- Spring Boot 3.2.2

### Dependencies needed
- spring-boot-starter-parent
- spring-boot-starter-web

### Frontend to Backend Layers Interaction Mechanisms
 - To know
   - This project didn't use any databases, all dummy articles were created in `Repository` layer.
   - As there are no databases, its better for users to call `localhost:8080/article` to first initialize a list of `Articles` than calling `localhost:8080/article/{id}` directly, which will never have any Articles initialized --> Its not a problem in real projects.
       - [more details](#how-to-store-list-of-articles-in-repository-layer)
    

![javaWeb drawio (1)](https://github.com/Liu-Chen-CS/backendChallenge-LiuChen/assets/158779475/8a58e331-6644-4387-b424-83934e439d4b)

![Snipaste_2024-03-03_11-11-54](https://github.com/Liu-Chen-CS/mapping-java/assets/158779475/61ae2325-229b-4cc0-a461-fb39d7968082)



### Article Structure
![Snipaste_2024-03-03_11-48-47](https://github.com/Liu-Chen-CS/mapping-java/assets/158779475/bf6ba3a6-6355-472d-bbdd-0e7066cc6495)
 - As `Article` extends `DBEntity`, Article then inherits all `attributes` and `methods` from `DBEntity`.
 - We used `HashSet` to store `ArticleBlock` type of instances, both `hashCode()` and `equals()` need to be `overridden`, [more details](#override-hashcode-equals-for-textblock)

### ArticleBlock Structure
- As `TextBlock`, `ImageBlock`, `GalleryBlock`, `VideoBlock` extends `ArticleBlock`, all these four instances then inherits `sortIndex` from `ArticleBlock`.
- All these four instances became as a type of `ArticleBlock`, which forms `Polymorphism`, that's why we are able to add them to the `HashSet`.

![Untitled Diagram drawio (2)](https://github.com/Liu-Chen-CS/backend-challenge/assets/158779475/8c606a13-0d4b-48fe-8f91-79041d7a9f5f)


### Articles to ArticleDtos Mapping Structure
<img width="997" alt="Screen Shot 2024-03-03 at 14 08 04" src="https://github.com/Liu-Chen-CS/backend-challenge/assets/158779475/43678a47-f16b-4ab6-bf9f-0e12062fcb17">

- An `ArrayList` to store each ArticleDto was initialized and ready for collecting each mapped `Article`, eventually this `ArrayList` will be sent back to `Controller` layer.


### Mapping Logics
- This diagram shows a step-by-step approach to how to map an Article to An ArticleDto
  1. for each `Article`, I will create a `vArticleDto`.
  2. start mapping for `id`, `title`,`description`,`author`.
  3. create `ArrayList <ArticleBlockDto>` to store `sortIndex`.
  4. loop through HashSet, for each ArticleBlock type instance, I will create an ArticleBlockDto to store sortIndex.
  5. add `ArticleBlockDto` to the List
  6. when finishing iterating `HashSet`, sort `ArrayList <ArticleBlockDto>`.
     - The `subtraction` to compare two numerical value might lead to incorrect result, therefore it's better to use compareTo(), [more info on StackOverflow]( https://stackoverflow.com/questions/2728793/java-integer-compareto-why-use-comparison-vs-subtraction)
   
  8. then add `ArrayList <ArticleBlockDto>` to blocks.
  9. One `ArticleDto` has just been initialized.
 
![Untitled Diagram drawio](https://github.com/Liu-Chen-CS/backend-challenge/assets/158779475/1d28f6b0-1bf1-4cfb-b3d7-663bebb016db)


### Sending Requests
 -  http://localhost:8080/article
    - Successfully retrieve a List of ArticleDtos with sorted ArticleBlockDto (descending)
    ![Snipaste_2024-03-03_15-57-21](https://github.com/Liu-Chen-CS/backend-challenge/assets/158779475/0ac07329-737f-4c86-8a51-85355cb38217)
 - http://localhost:8080/article/{id}
    - Successfully retrieve an ArticleDto by id
    ![Snipaste_2024-03-03_16-04-30](https://github.com/Liu-Chen-CS/backend-challenge/assets/158779475/c669f0f1-3d71-467f-8160-e5dcd351eaae)
    - An error was shown when id was not matched based on the List.
    ![Snipaste_2024-03-03_16-09-48](https://github.com/Liu-Chen-CS/backend-challenge/assets/158779475/4c421437-18b8-4794-ad27-0cd7648bc76f)

### Inform the user, when new implementation of ArticleBlock is created
 - When new instances being found, users can find it in log
   ![Snipaste_2024-03-03_16-18-41](https://github.com/Liu-Chen-CS/backend-challenge/assets/158779475/4c5633b5-b9e8-45b9-a960-ad3df72721f9)




### Override hashCode(), equals() for TextBlock
 - As `HashSet` does not allow duplicates, and we added multiple `TextBlocks` to `HashSet`, these two methodes from Object class therefore must be overriden.

### How to store List of Articles in Repository layer
 - set up a globle variable
 - the first request must be `localhost.8080/article`, so `this.temp` can be initialized with all dummy Articles, even multiple `localhost.8080/article` being sent, no duplicated Article will be created.
 - `localhost.8080/article/{id}` can be used after initializing the List.
 ![Snipaste_2024-03-03_16-23-10](https://github.com/Liu-Chen-CS/backend-challenge/assets/158779475/5f1740a4-10b4-45e1-ad54-b99af1d60cd9)

   


