<script>
  // Show seat section when cinema is selected
  function showSeatSection() {
      document.getElementById('bookingForm').classList.add('cinema-selected');

      // Update selected cinema name
      const selectedCinema = document.querySelector('input[name="cinemaId"]:checked');
      if (selectedCinema) {
          const cinemaLabel = document.querySelector('label[for="' + selectedCinema.id + '"] h6');
          document.getElementById('selectedCinemaDisplay').textContent = cinemaLabel.textContent;
      }
  }

  // Update summary when seats are selected
  function updateSummary() {
      const selectedSeats = document.querySelectorAll('.seat-checkbox:checked');
      let total = 0;
      let seatNames = [];

      selectedSeats.forEach(seat => {
          seatNames.push(seat.value);
          total += parseInt(seat.dataset.price);
      });

      document.getElementById('selectedSeatsDisplay').textContent =
          seatNames.length > 0 ? seatNames.join(', ') : 'Chưa chọn';

      document.getElementById('totalPriceDisplay').textContent =
          total.toLocaleString('vi-VN') + ' VNĐ';

      // Update showtime display
      const selectedShowtime = document.querySelector('input[name="showtimeId"]:checked');
      if (selectedShowtime) {
          const showtimeLabel = document.querySelector('label[for="' + selectedShowtime.id + '"]');
          document.getElementById('selectedShowtimeDisplay').textContent = showtimeLabel.textContent.trim();
      }
  }

  // Update showtime when selected
  document.querySelectorAll('input[name="showtimeId"]').forEach(radio => {
      radio.addEventListener('change', updateSummary);
  });
</script>