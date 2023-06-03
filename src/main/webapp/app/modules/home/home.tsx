import './home.scss';

import React from 'react';
import { Link } from 'react-router-dom';
import { Translate } from 'react-jhipster';
import { Row, Col, Alert } from 'reactstrap';

import { useAppSelector } from 'app/config/store';

export const Home = () => {
  const account = useAppSelector(state => state.authentication.account);

  return (
    <Row>
      <div className="home-container">
        <div className="home-background-image"></div>
        <div className="home-overlay"></div>
        <div className="home-content">
          <h1>Modulo de ingresos y reingresos</h1>
        </div>
      </div>
    </Row>
  );
};

export default Home;
