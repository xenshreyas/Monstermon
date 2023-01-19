# <span style="color:AliceBlue"> Monster Simulator - <span style="color:fireBrick"> **Monstermon Adventures** </span>

## <span style="color:AliceBlue"> **What will the application do?**

<div style="text-align: justify">
<p>"Monstermon Adventures" is an application that brings the excitement of monster collection and battling to your fingertips. Create and customize your own monsters by giving them unique names, selecting their types, and assigning them health points. Assemble a team of 5 powerful monsters and challenge other teams to epic battles. The game will determine the victor and keep track of your progress, so you can pick up right where you left off whenever you want to play. Experience the thrill of monster collecting and battling anytime, anywhere with Monstermon. </p>
</div>

### <span style="color:Beige"> Monster Collection </span>

<div style="text-align: justify">
<p>In Monstermon, players can build their own monster collection by creating unique monsters with names, types, and health points. These monsters can be assigned to specific teams, ready to be called upon for thrilling battles against other teams. The ability to customize and strategically assemble teams adds an extra layer of excitement to the monster battling experience.</p>
</div>

### <span style="color:Beige"> Monster Battling </span>

<div style="text-align: justify">
<p>In Monstermon, monsters come in three different types: fire, water, and grass. Each monster has a base damage of 50, which is then multiplied by a type-specific multiplier during battle. If a monster has a type advantage over its opponent, its damage multiplier is increased to 1.5, while a type disadvantage results in a multiplier of 0.5. This creates an exciting and strategic element to the battles, as players must consider the types of their monsters and their opponents' to maximize their damage. </p>
</div>
<div style="text-align: left">
<p> Type advantages and disadvantages in Monstermon are calculated using the following system: </p>
</div>
<div style="text-align: center">
<img src="data/type-advantages.jpg" style="width:50%;">
</div>

<div style="text-align: justify">
<p>Monstermon battles are intense one-on-one matchups between monsters. Each battle continues until one monster's health points are depleted, at which point the next monster from the respective team enters the arena. This process continues until all the monsters on one team have been defeated, resulting in a victorious team. The tension and excitement build as players strategize and select their monsters, knowing that one false move could lead to defeat. </p>
</div>

### <span style="color:Beige"> Implementation </span>
<div style="text-align: justify">
<p>The Monstermon application will be designed using two main classes: "Monster" and "Team." The "Monster" class represents each individual monster, with attributes such as name, type, and health points. The "Team" class is a collection of "Monster" objects, held together in an ArrayList. It includes additional attributes such as the team's name, and the list of monsters it comprises of. This class-based approach allows for a clear and organized structure for the game's logic and functionality.</p>
<p>In Monstermon, the "Monster" class is equipped with several methods to manage and manipulate the monsters, such as "renameMonster()" to change the monster's name, "getHp()" to access the monster's health points, and "getType()" to determine the monster's type. The "Team" class is also outfitted with methods to manage the team's roster, such as "renameTeam()" to change the team's name, "addToTeam()" to add a monster to the team, "removeFromTeam()" to remove a monster from the team, and "battle()" to initiate a battle against another team. These methods provide players with the tools to fully customize and control their teams, adding depth and strategy to the game.</p>
</div>

## <span style="color:AliceBlue"> **Who will use it?**

<div style="text-align: justify"> 
<p>Monstermon is the perfect game for fans of monster battling and role-playing battle simulation games. The application offers an exciting and engaging experience that can be enjoyed by players of all ages. Users can create and customize their own monsters and teams, strategize their team compositions, and battle against other teams. Whether you're a seasoned player or new to the genre, Monstermon offers an immersive and thrilling experience for all those who are passionate about monster battling.</p>
</div>

## <span style="color:AliceBlue"> **Why is this project of interest to you?**

<div style="text-align: justify"> 
<p>As a dedicated fan of the Pokémon franchise, the development of this monster collection and battling simulation game holds a special significance to me. My passion for this genre of games has only grown stronger as I delve into the intricate functionalities and concepts behind them. The captivating stories and adventure-style gameplay of the Pokémon franchise have always captivated me and helped me sharpen my problem-solving skills and strategic thinking.</p>
<p>With this project, I aim to take my understanding of both Pokémon and Java programming to a new level by creating a smaller scale simulation that captures the essence of the Pokémon experience. I am excited to explore the possibilities of this project and push my skills to their limits.</p>
</div>

## <span style="color:AliceBlue"> **User Stories**
<div style="text-align: justify">
<ul>
<li>As a user, I want to have the ability to create unique monsters by assigning them a name, type and a specific number of health points. </li>
<li>As a user, I want to be able to assemble a team of monsters, carefully selected from my collection. </li>
<li>As a user, I want to have the ability to remove any monsters that do not meet my standards from my team, allowing me to fine-tune and optimize my team's composition.</li>
<li>As a user, I want to be able to engage in thrilling battles against other teams of monsters.</li>
<li>As a user, I want to be able to rename my team to give it a personal touch.</li>
<li>As a user, I want to be able to view the characteristics of individual monsters within my team, such as their name, type and health points.</li>
</ul>
</div>

## <span style="color:AliceBlue"> **Future Plans**
<div style="text-align: justify">
<p>In the future, I plan to expand the Monstermon universe by adding more types of monsters to the game, and creating a more complex system of type advantages and disadvantages. Furthermore, I aim to enhance the user interface by implementing visually appealing sprites and other graphics that will make the game more immersive. Additionally, I want to develop a system that allows monsters to have specific Skill Values such as attack, defense, and speed adding yet another layer of strategy and depth to the battling experience.</p>
</div>