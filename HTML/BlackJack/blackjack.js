// Blackjack JS By Omera Ezike

// Card Variables
let suits = [ "Hearts", "Clubs", "Diamonds", "Spades" ], values = [ "Ace",
		"King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six",
		"Five", "Four", "Three", "Two" ];

// Game variables
let gameStarted = false, playerWon = false, gameOver = false;
let playerScore = 0, dealerScore = 0, deck = [], playerHand = [], dealerHand = [];

// Creates a string based on a card's values
function printHand(hand) {
	let str = "";
	for (let i = 0; i < hand.length; i++) {
		str += cardStr(hand[i]) + "\n";
	}
	return str;
}

// Calculates the score
function calcScore(hand) {
	let score = 0;
	let hasAce = false;

	for (let i = 0; i < hand.length; i++) {
		score += getCardValue(hand[i]);
		if (hand[i] === "Ace") {
			hasAce = true;
		}
	}

	if (hasAce && score + 10 < 21) {
		return score + 10;
	}

	return score;
}

// Returns integer value of a card
function getCardValue(card) {
	switch (card.value) {
	case "Ace":
		return 1;

	case "Two":
		return 2;

	case "Three":
		return 3;

	case "Four":
		return 4;

	case "Five":
		return 5;

	case "Six":
		return 6;

	case "Seven":
		return 7;

	case "Eight":
		return 8;

	case "Nine":
		return 9;

	default:
		return 10;
	}
}

// Returns a string based on score
function printScore(score) {
	return ("Score: " + score + "\n");
}

// Returns a string based on a card's values
function cardStr(card) {
	return card.value + " of " + card.suit;
}

// Creates a new Deck
function createDeck() {
	let deck = [];
	for (let s = 0; s < suits.length; s++) {
		for (let v = 0; v < values.length; v++) {
			// Creates a card object
			let card = {
				suit : suits[s],
				value : values[v]

			};
			deck.push(card);
		}
	}
	deck = shuffle(deck);
	return deck;
}

// Draws a card from top of deck
function getCard() {
	return deck.shift();
}

// Shuffles the deck
function shuffle(array) {
	var currentIndex = array.length, temporaryValue, randomIndex;

	// While there remain elements to shuffle...
	while (0 !== currentIndex) {

		// Pick a remaining element...
		randomIndex = Math.floor(Math.random() * currentIndex);
		currentIndex -= 1;

		// And swap it with the current element.
		temporaryValue = array[currentIndex];
		array[currentIndex] = array[randomIndex];
		array[randomIndex] = temporaryValue;
	}

	return array;
}

// Displays Player cards and score
function updatePlayerState() {
	if (!gameOver) {
		document.getElementById("playerHand").innerText = printHand(playerHand);
		playerScore = calcScore(playerHand);
		document.getElementById("playerScore").innerText = printScore(playerScore);
	}
}

// Displays Dealer cards and score
function updateDealerState() {
	if (!gameOver) {
		document.getElementById("dealerHand").innerText = printHand(dealerHand);
		dealerScore = calcScore(dealerHand);
		document.getElementById("dealerScore").innerText = printScore(dealerScore);
	}
}

// Starts a new game
function newGame() {
	console.log("Starting a new game...");
	gameOver = false;
	playerWon = false;

	// Resets deck, dealer, and player hands and scores
	deck = createDeck();
	playerHand.length = 0;
	dealerHand.length = 0;
	playerScore = 0;
	dealerScore = 0;
	playerHand.push(getCard(), getCard());
	dealerHand.push(getCard(), getCard());

	// Showing and hiding buttons
	playerArea.style.display = "block";
	compArea.style.display = "block";
	btnNewGame.style.display = "none";
	endMsg.style.display = "none";
	btnHit.style.display = "inline";
	btnStay.style.display = "inline";
	updatePlayerState();
	updateDealerState();
}

// The dealer takes its turn(s) and the result of the game is displayed
function endGame() {

	winLose = "You Win!";
	colorTxt = winLose.fontcolor("green");

	// Player Blackjack
	if (playerScore == 21) {
		playerWon = true;
		gameOver = true;
		endMsg.innerHTML = colorTxt;
	}

	// Player Bust
	if (playerScore > 21) {
		playerWon = false;
		gameOver = true;
		winLose = "Bust! Dealer Wins.";
		colorTxt = winLose.fontcolor("red");
		endMsg.innerHTML = colorTxt;
	}

	// Dealer Turn(s)
	if (!gameOver) {
		while (dealerScore < 17) {
			dealerHand.push(getCard());
			updateDealerState();
		}
	}

	// if player score > dealer score player wins
	if (!gameOver) {

		// Dealer Bust
		if (dealerScore > 21) {
			playerWon = true;
			gameOver = true;
			endMsg.innerHTML = colorTxt;

		}

		else if (playerScore > dealerScore) {
			playerWon = true;
			gameOver = true;
			endMsg.innerHTML = colorTxt;
		}

		else if (playerScore === dealerScore) {
			playerWon = false;
			gameOver = true;
			endMsg.innerText = "Draw.";
		}

		else {
			playerWon = false;
			gameOver = true;
			winLose = "You Lose.";
			colorTxt = winLose.fontcolor("red");
			endMsg.innerHTML = colorTxt;

		}

	}

	// Showing and hiding buttons
	btnNewGame.style.display = "inline";
	endMsg.style.display = "inline";
	btnHit.style.display = "none";
	btnStay.style.display = "none";
}

// Button Listeners
let btnNewGame = document.getElementById("btnNewGame");
let btnHit = document.getElementById("btnHit");
let btnStay = document.getElementById("btnStay");
let playerArea = document.getElementById("playerArea");
let compArea = document.getElementById("compArea");
let endMsg = document.getElementById("endMsg");

// Starts a new game
btnNewGame.addEventListener('click', function() {
	newGame();
});

// Player draws a card and updates state
btnHit.addEventListener('click', function() {

	playerHand.push(getCard());
	updatePlayerState();

	// Player Bust
	if (playerScore > 21) {
		endGame();
	}

});

// Dealer takes its turns and ends game
btnStay.addEventListener('click', function() {
	endGame();
});