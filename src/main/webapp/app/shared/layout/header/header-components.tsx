import React from 'react';
import { Translate } from 'react-jhipster';

import { NavItem, NavLink, NavbarBrand } from 'reactstrap';
import { NavLink as Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

export const BrandIcon = props => (
  <div {...props} className="brand-icon">
    <img src="content/images/logo-udea2.png" alt="Logo" />
  </div>
);

export const Brand = () => (
  <NavbarBrand tag={Link} to="/" className="brand-logo">
    <BrandIcon />
    <span className="brand-title">Ingresos & Reingresos</span>
  </NavbarBrand>
);

export const Home = () => (
  <div className="d-flex">
    <NavItem>
      <NavLink tag={Link} to="/" className="d-flex align-items-center">
        <FontAwesomeIcon icon="home" />
        <span>
          <Translate contentKey="global.menu.home">Home</Translate>
        </span>
      </NavLink>
    </NavItem>
    <NavItem>
      <NavLink tag={Link} to="/admin-panel" className="d-flex align-items-center">
        <FontAwesomeIcon icon="user" />
        <span>Panel de administrador</span>
      </NavLink>
    </NavItem>
  </div>
);
