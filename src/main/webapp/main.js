"use strict";

var $ = require('jquery');
const React = require('react');
const ReactDOM = require('react-dom')
const {Table,Column,Cell} = require('fixed-data-table');

var WeatherTable = React.createClass({
  getInitialState: function() {
    return {
      weatherHourly: []
    };
  },
  render() {
    return (
      <Table
              rowHeight={25}
              rowsCount={this.state.weatherHourly.length}
              width={425}
              height={this.state.weatherHourly.length * 25 + 30}
              headerHeight={28}>
        <Column
          header={<Cell>Time</Cell>}
           cell={props => (
            <Cell {...props}>
              {this.state.weatherHourly[props.rowIndex]["time"]}
            </Cell>
            )}
          width={100}
        />
        <Column
          header={<Cell>Summary</Cell>}
           cell={props => (
            <Cell {...props}>
              {this.state.weatherHourly[props.rowIndex]["summary"]}
            </Cell>
            )}
          width={100}
        />
        <Column
          header={<Cell>Temp</Cell>}
           cell={props => (
            <Cell {...props}>
              {this.state.weatherHourly[props.rowIndex]["temp"]}
            </Cell>
            )}
          width={100}
        />
        <Column
          header={<Cell>Feels Like</Cell>}
           cell={props => (
            <Cell {...props}>
              {this.state.weatherHourly[props.rowIndex]["feelsLike"]}
            </Cell>
            )}
          width={100}
        />
    </Table>
    )
  }
})

var StationListTable = React.createClass ({
  getInitialState: function() {
    return {
      stationList: []
    };
  },

  componentDidMount: function() {
    this.serverRequest = $.get(this.props.source + this.props.whichset, function (result) {
      this.setState({
        stationList: result.records
      });
    }.bind(this));
  },

  render() {
    return (
      <Table
        rowHeight={25}
        rowsCount={this.state.stationList.length}
        width={425}
        height={this.state.stationList.length * 25 + 30}
        headerHeight={28}>
        <Column
          header={<Cell>Station</Cell>}
           cell={props => (
            <Cell {...props}>
              {this.state.stationList[props.rowIndex]["stationName"]}
            </Cell>
            )}
          width={225}
        />
        <Column
          header={<Cell>Docks</Cell>}
           cell={props => (
            <Cell {...props}>
              {this.state.stationList[props.rowIndex]["availableDocks"]}
            </Cell>
            )}
          width={50}
        />
        <Column
          header={<Cell>Bikes</Cell>}
           cell={props => (
            <Cell {...props}>
              {this.state.stationList[props.rowIndex]["availableBikes"]}
            </Cell>
            )}
          width={50}
        />
        <Column
          header={<Cell>Status</Cell>}
           cell={props => (
            <Cell {...props}>
              {this.state.stationList[props.rowIndex]["statusValue"]}
            </Cell>
            )}
          width={100}
        />
      </Table>
    )
  }
})

ReactDOM.render(<StationListTable
                    whichset={document.location.search}
                    source="/bike" />,
                document.getElementById('stations'))

ReactDOM.render(<WeatherTable/>,
                document.getElementById('weather'))