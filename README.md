# <span style="color:AliceBlue"> Monster Fighting Simulator - <span style="color:fireBrick"> **Mostromon** </span>

## <span style="color:AliceBlue"> **What will the application do?**

<div style="text-align: justify">
<p>The application will implement monster collection and battling. Monsters will have certain attributes such as names, types and health-points. The application will allow users to create and name monsters, choose their types and the amount of health-points they have. Then, they will be able to compose a team of 5 monsters that can battle amongst another team of 5 monsters. The application will then battle the two teams, and determine the victor of the battle. </p>
</div>

### <span style="color:Beige"> Monster Collection </span>

<div style="text-align: justify">
<p></p>
</div>

### <span style="color:Beige"> Monster Battling </span>

<div style="text-align: justify">
<p>Monsters will be able to be of the following types: fire, water and plant. When one monster is fighting another monster, it will have a base damage of 50. This number will be multiplied by a multiplier, depending on the type of the opposing monster that is being fought. If the user's monster has a type-advantage, this multiplier would be 1.5, while it would be 0.5 if the monster is at a type-disadvantage. </p>
</div>
<div style="text-align: left">
<p> Type advantages and disadvantages will be determined as follows: </p>
</div>
<div style="text-align: center">
<img src="data/type-advantages.jpg" style="width:50%;">
</div>

<div style="text-align: justify">
<p>When two monsters are pitted against each other, they will fight each other until the health-points of either monster is reduced to 0. At this point, the next monster in the team would replace the fainted monster. This would continue until either team of monsters has fainted, deeming the other team victorious.</p>

### <span style="color:Beige"> Implementation </span>
<p>In code, the application would be implemented using two classes: Monster and Team. The Monster class would represent a monster, with its attributes being name, type and health-points. The Team class would be a list of Monster objects implemented using ArrayLists. The Team class would also have attributes, including name and the list of monsters it contains.</p>
<p>The Monster class would have methods including renameMonster(), getHp() and getType(). The Team class would have methods including renameTeam(), addToTeam(), removeFromTeam() and battle(). </p>
</div>

## <span style="color:AliceBlue"> **Who will use it?**

## <span style="color:AliceBlue"> **Why is this project of interest to you?**