import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/AirlineServlet")
public class AirlineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Flight> flights = new ArrayList<>();

    public AirlineServlet() {
        super();
        flights.add(new Flight("OA101", "New York", "London", 100));
        flights.add(new Flight("OA102", "San Francisco", "Tokyo", 150));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("getFlights".equals(action)) {
            String json = new Gson().toJson(flights);
            response.setContentType("application/json");
            response.getWriter().write(json);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightNumber = request.getParameter("flight-number");
        String passengerName = request.getParameter("passenger-name");
        boolean booked = false;

        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                if (flight.getBooked() < flight.getCapacity()) {
                    flight.setBooked(flight.getBooked() + 1);
                    booked = true;
                }
                break;
            }
        }

        response.setContentType("application/json");
        if (booked) {
            response.getWriter().write(new Gson().toJson(new Message("success", "Ticket booked for " + passengerName + " on flight " + flightNumber + ".")));
        } else {
            response.getWriter().write(new Gson().toJson(new Message("error", "Flight is fully booked or not found.")));
        }
    }

    private class Flight {
        private String flightNumber;
        private String origin;
        private String destination;
        private int capacity;
        private int booked;

        public Flight(String flightNumber, String origin, String destination, int capacity) {
            this.flightNumber = flightNumber;
            this.origin = origin;
            this.destination = destination;
            this.capacity = capacity;
            this.booked = 0;
        }

        public String getFlightNumber() {
            return flightNumber;
        }

        public String getOrigin() {
            return origin;
        }

        public String getDestination() {
            return destination;
        }

        public int getCapacity() {
            return capacity;
        }

        public int getBooked() {
            return booked;
        }

        public void setBooked(int booked) {
            this.booked = booked;
        }
    }

    private class Message {
        private String status;
        private String message;

        public Message(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}
