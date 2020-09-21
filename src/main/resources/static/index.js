$(document).ready( function() {

  var gameId = null;

  // Creates game at startup.
  $.ajax({
      type: 'POST',
      url: '/api/game',
      success: function(game) {
        gameId = game.id;
        var row = $("#statsRow");
        $("#roundsPlayed").html(game.summary.roundsPlayed);
        $("#p1Wins").html(game.summary.roundsWonByPlayer1);
        $("#p2Wins").html(game.summary.roundsWonByPlayer2);
        $("#draws").html(game.summary.roundsDraw);
      },
      error: function(request, status, error) {
        alert('Could not process the operation. Please, try again');
      }
    });


  // Plays a round.
  $('#gameForm').submit(function() {
    $.ajax({
      type: 'POST',
      url: '/api/game/' + gameId + '/round',
      contentType:"application/json",
      success: function(round) {
        var result = null;

        $("#roundsPlayed").html(function(i, val) { return +val+1 });

        if (round.result === 0) {
          result = "Draw";
          $("#draws").html(function(i, val) { return +val+1 });
        } else if (round.result === 1) {
          result = "Player 1 won";
          $("#p1Wins").html(function(i, val) { return +val+1 });
        } else if (round.result === -1) {
          result = "Player 2 won"
          $("#p2Wins").html(function(i, val) { return +val+1 });
        }

        var newRow = "<tr><td>" + round.player1Play + "</td><td>" + round.player2Play + "</td><td>" + result + "</td></tr>"
        $("#roundsTableBody").append(newRow);

      },
      error: function(request, status, error) {
        alert('Could not process the operation. Please, try again');
      }
    });
    return false;
  });

  // Restarts the game.
  $('#statsForm').submit(function() {
    $.ajax({
      type: 'DELETE',
      url: '/api/game/' + gameId + '/rounds',
      contentType:"application/json",
      success: function(game) {
        var row = $("#statsRow");
        $("#roundsPlayed").html(game.summary.roundsPlayed);
        $("#p1Wins").html(game.summary.roundsWonByPlayer1);
        $("#p2Wins").html(game.summary.roundsWonByPlayer2);
        $("#draws").html(game.summary.roundsDraw);

        $("#gameTable > tbody").empty();
      },
      error: function(request, status, error) {
        alert('Could not process the operation. Please, try again');
      }
    });
    return false;
  });

});
