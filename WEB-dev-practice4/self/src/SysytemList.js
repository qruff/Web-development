import React from 'react';
import axios from 'axios';

export default class SystemList extends React.Component {
  ish;
  componentDidMount() {
    axios.get(`https://new.vyatsu.ru/sveden/common/`)
        .then(res => {
            const tp = res.data;
            this.ish = tp;
            var dc =new DOMParser().parseFromString(this.ish,"text/html");
            var table = dc.getElementsByTagName("table")[4];
            var rows = table.rows;
            for (var i = 0; i < rows.length; i++) {
              var cells = rows[i].cells;
                var cellValue = cells[1].innerHTML;
                var c = document.getElementById("container").innerText += cellValue ;               
                console.log(c);
            }
            
      })
      
  }
  render() {
    return (
      <div id='container' class="cont">
        
      </div>
    )
  }
}