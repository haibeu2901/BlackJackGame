# Blackjack Game
The main project folder for learning and practicing JSP, Servlets, and MVC architecture in Java web development

Live Demo: :point_right: [here]()

## Table of Contents
- [Description](#description)
- [Preview Screenshot](#preview-screenshot)
- [Technology](#technology)
- [Useful Resources](#useful-resources)
- [How Can Get Started](#how-can-get-started)
- [Learn More](#learn-more)
- [License & Copyright](#license--copyright)

## Description
- This is a fully-featured Blackjack card game implemented with Java web technologies
- The game follows standard casino rules with betting system and proper card scoring
- Players can place bets, hit or stand, and play against a dealer who follows traditional rules
- The dealer automatically hits until 17 and stands on 17+
- Blackjack (Ace + 10-value card) pays 3:2 as in real casinos
- The application demonstrates proper MVC architecture with clean separation of concerns
- This web application works well on desktop, not optimized for mobile
- The project was created as a learning exercise for Java EE concepts and web development

## Preview Screenshot
<div align="center">
<!--   <img src="" alt="Game Start" width="45%"></img> &nbsp;&nbsp; <img src="" alt="Placing Bet" width="45%"></img>
  <img src="" alt="Game Play" width="45%"></img> &nbsp;&nbsp; <img src="" alt="Win Hand" width="45%"></img>
  <img src="" alt="Dealer Blackjack" width="45%"></img> &nbsp;&nbsp; <img src="" alt="Player Blackjack" width="45%"></img> -->
</div>
  
## Technology
**1. Frontend**
  - CSS - For styling the game interface
  - JSP - JavaServer Pages for dynamic HTML generation
  - JSTL - JSP Standard Tag Library for clean, scriptlet-free pages

**2. Backend**
  - Servlets - Java classes used to handle HTTP requests and responses
  - Java Classes - Card, Deck, Hand, and BlackjackGame for game logic

**3. Database**
  - No database required - Game state maintained in session

**4. Tool**
  - Netbeans 8.2 or Eclipse IDE
  - Java JDK 8
  - Apache Tomcat 8.5+

## Useful Resources
#| Name | Description
-| ---- | -----------
1| [WebContent Folder](src/webapp) | JSP files and static resources
2| [Java Source Folder](src/blackjack) | Source code for game logic and controller
3| [CSS Files](src/webapp/css) | Styling for the game interface
4| [WEB-INF Folder](src/webapp/WEB-INF) | Configuration files including web.xml

## How Can Get Started
- Using NetBeans 8.2 or Eclipse IDE to start project easier
- After opening project in IDE, import JSTL 1.2.1 library that's supported by the IDE
- Set up Apache Tomcat server in your IDE
- Build and deploy the project to Tomcat
- Access the application at `http://localhost:8080/blackjack-game/`

## Learn More
- [Java Servlet Documentation](https://javaee.github.io/servlet-spec/)
- [JSP Documentation](https://docs.oracle.com/javaee/5/tutorial/doc/bnagx.html)
- [JSTL Documentation](https://docs.oracle.com/javaee/5/tutorial/doc/bnakc.html)
- [Blackjack Rules](https://bicyclecards.com/how-to-play/blackjack/)

## License & Copyright
&copy; 2025 Hai Doan haibeu2901 Licensed under the [GPL-3.0 LICENSE](https://github.com/haibeu2901/BlackJackGame/blob/main/LICENSE).

> :love_you_gesture: Feel free to use my repository and star it if you find something interesting :love_you_gesture:
