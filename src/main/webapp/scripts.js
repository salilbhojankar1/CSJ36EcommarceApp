document.addEventListener('DOMContentLoaded', () => {
    fetch('/AirlineServlet?action=getFlights')
        .then(response => response.json())
        .then(data => {
            const flightsDiv = document.getElementById('flights');
            data.forEach(flight => {
                const flightInfo = document.createElement('div');
                flightInfo.textContent = Flight ${flight.flightNumber}: ${flight.origin} ${flight.destination} Capacity: ${flight.capacity}, Booked: ${flight.booked};
                flightsDiv.appendChild(flightInfo);
            });
        });

    const form = document.getElementById('booking-form');
    form.addEventListener('submit', (e) => {
        e.preventDefault();
        const formData = new FormData(form);
        fetch('/AirlineServlet', {
            method: 'POST',
            body: new URLSearchParams(formData)
        })
        .then(response => response.json())
        .then(data => {
            alert(data.message);
            location.reload();
        });
    });
});
