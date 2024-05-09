# VdoCipher Integration with Spring Boot 📽️
#### ( Server-side Code )
A server-side Spring Boot code that presents a basic demo for integration of VdoCipher Video Management with Fullstack Web Application. For the upload process, Dropzone.js package was used on the client-side react.js app. 
You can find the client-side app at the following repo: [vdocipher-webapp-integration-react-code](https://github.com/MariamAtef226/vdocipher-webapp-integration-react-code)



## :ledger: Index

- [About](#beginner-about)
- [Pre-Requisites](#notebook-pre-requisites)
- [Customization](#hammer_and_wrench-customization)
- [Installation and Run](#electric_plug-installation-and-run)
- [File Structure](#file_folder-file-structure)
- [Contribution](#fire-contribution)
- [Resources](#page_facing_up-resources)
- [Author](#star2-author)
- [License](#lock-license)


##  :beginner: About
The repository includes a simple demo implementation for the functions of video upload and preview client-side App using Spring Boot framework. The server-side app includes 4 endpoints:
- getCredentials: to return video credentials to upload at client-side.
- deleteVideo: to delete video by its id.
- addVideoToDatabase: to add video's id and status in our database when upload is successful.
- getOtp: to return otp and playback info for a given videoID to play at client-side.
_PS: The app doesn't include any authorization or authentication for simplicity, since this project is just a demo for VdoCipher integration with Spring Boot to guide you_

## :notebook: Pre-Requisites
- VdoCipher Account
- JDK 17
- MySQL Server (needed by the Spring Boot app)
- The React.js client-side app to test this project (can be found at this [link](https://github.com/MariamAtef226/vdocipher-webapp-integration-react-code))
- Node.js and npm (for the react.js app)


## :hammer_and_wrench: Customization:
- in VideoTestController.java: set API_SECRET attribute with an APIsecret value from your account (You can find the API secret key for your account by logging into the Dashboard -> Config tab.)
- in application.properties and application-local.properties: configure parameters according to your database credentials
  
##  :electric_plug: Installation and Run
```
$ git clone <repository-url>
$ cd spring-boot-app-directory
```
Build the app:
```
$ ./mvnw clean package
```
If you're using Windows, use mvnw.cmd instead of ./mvnw.

Run the app:
```
$ java -jar target/application-name.jar
```
Replace application-name.jar with the name of your JAR file generated during the build process.

Access the app on http://localhost:8080/.


##  :file_folder: File Structure
```
.
├── src
|   ├── test/java/com/VdoCipherIntegration // ignore
│   ├── main
|   |   ├── java/com/VdoCipherIntegration
|   |   |   ├── config    // includes cors security configuration
|   |   |   ├── controller    // includes VideoTestController (where all of our logic lies)
|   |   |   ├── dto         // includes custome classes for error and responses (not important)
|   |   |   ├── entity       // include Video entity and Enums class
|   |   |   ├── exception    // includes common exception classes
|   |   |   ├── repository    // includes a repo interface for Video Entity
|   |   |   ├── BackendApplication.java     // where the app is run
|   |   ├── resources
|   |   |   ├── application.properties 
|   |   |   ├── application-local.properties
├── .gitattributes
├── .gitignore
├── mvnw
├── mvwn.cmd
├── pom.xml
├── LICENSE
└── README.md
```
_PS: The project doesn't follow the conventional Spring Boot app structure since it's just for the purpose of showing integration steps_


##  :fire: Contribution
Feel free to contribute to this project in separate branches if you came up with further advancements, new features or discovered a bug for this demo.


##  :page_facing_up: Resources
- [VdoCipher server docs](https://www.vdocipher.com/docs/server/)
- [VdoCipher player embedding docs](https://www.vdocipher.com/docs/player/v2/)


## :star2: Author
[Mariam Atef](https://www.github.com/MariamAtef226)


##  :lock: License
[![License](http://img.shields.io/:license-MIT-blue.svg)](https://opensource.org/license/mit)
