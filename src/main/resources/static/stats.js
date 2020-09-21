$(document).ready( function() {

  $.ajax({
      type: 'GET',
      url: '/api/game/stats',
      success: function(stats) {
        $("#roundsPlayed").html(stats.roundsPlayed);
        $("#p1Wins").html(stats.roundsWonByPlayer1);
        $("#p2Wins").html(stats.roundsWonByPlayer2);
        $("#draws").html(stats.roundsDraw);
      },
      error: function(request, status, error) {
        alert('Could not process the operation. Please, try again');
      }
    });

});