var DashBoard = React.createClass({
    componentDidMount: function() {
        var DEFAULT_LAT_LONG = [37.090240, -95.712891],
            DEFAULT_ZOOM = 4;
        L.mapbox.accessToken = 'pk.eyJ1IjoiYXNsYXRlciIsImEiOiItYTNLNkkwIn0.uf1rwYpeylp32z8EVOjXpg';
        this.map = L.mapbox.map('map', 'mapbox.streets', {attributionControl: false}).
            setView(DEFAULT_LAT_LONG, DEFAULT_ZOOM).
            addControl(L.mapbox.geocoderControl('mapbox.places'));
        this.drawnItems = L.featureGroup().addTo(this.map);
    },

    render: function() {
        return (
            <div id="map">
            </div>
        );
    }
});

React.render(<DashBoard/>, document.getElementById("wrapper"));
