"use strict";

var $ = require('jquery');
const React = require('react');
const ReactDOM = require('react-dom')
const {Table,Column,Cell} = require('fixed-data-table');

var WeatherTable = React.createClass({
  render() {
    return (
      <Table
              rowHeight={25}
              rowsCount={5}
              width={100}
              height={100}
              headerHeight={28}>
        <Column
          header={<Cell>Status</Cell>}
           cell={props => (
            <Cell {...props}>
              Some text value
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