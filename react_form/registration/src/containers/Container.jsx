import React, {Component} from 'react';  

/* Import Components */  
import Input from '../components/Input'; 
import Button from '../components/Button'

class Container extends Component {  
  constructor(props) {
    super(props);

    this.state = {
      newUser: {
        name: '',
        NPI: '',
        businessAddress: '',
        telephone: '',
        email: ''

      },

    }
    
    this.handleFullName = this.handleFullName.bind(this);
    this.handleClearForm = this.handleClearForm.bind(this);
    this.handleInput = this.handleInput.bind(this);
  }

  /* This lifecycle hook gets executed when the component mounts */
  
  handleFullName(e) {
   let value = e.target.value;
   this.setState( prevState => ({ newUser : 
        {...prevState.newUser, name: value
        }
      }), () => console.log(this.state.newUser))
  }

  handleInput(e) {
       let value = e.target.value;
       let name = e.target.name;
   this.setState( prevState => ({ newUser : 
        {...prevState.newUser, [name]: value
        }
      }), () => console.log(this.state.newUser))
  }


  handleClearForm(e) {
  
      e.preventDefault();
      this.setState({ 
        newUser: {
          name: '',
          NPI: '',
          businessAddress: '',
          telephone: '',
          email: ''
        },
      })
  }

  render() {
    return (
    
        <form className="container-fluid" onSubmit={this.handleFormSubmit}>
       
            <Input inputType={'text'}
                   title= {'Full Name'} 
                   name= {'name'}
                   value={this.state.newUser.name} 
                   placeholder = {'Enter your full name'}
                   handleChange = {this.handleInput}/> 
        
          <Input inputType={'text'} 
                name={'NPI'}
                 title= {'NPI Number'} 
                 value={this.state.newUser.npi} 
                placeholder = {'Enter your NPI Number'}
                 handleChange={this.handleInput} /> 

          <Input inputType={'text'} 
                name={'telephone'}
                 title= {'Telephone Number'} 
                 value={this.state.newUser.telephone}
                placeholder = {'Enter your Telephone number'}
                 handleChange={this.handleInput} /> 

         <Input inputType={'text'} 
                name={'Business Address'}
                 title= {'Business Address'} 
                 value={this.state.newUser.age} 
                placeholder = {'Enter your Business Address'}
                 handleChange={this.handleInput} /> 

          <Input inputType={'text'} 
                name={'Email Address'}
                 title= {'Email  Address'} 
                 value={this.state.newUser.age} 
                placeholder = {'Enter your Email  Address'}
                 handleChange={this.handleInput} />  

          <Button 
              action = {this.handleFormSubmit}
              type = {'primary'} 
              title = {'Register'} 
            style={buttonStyle}
          /> { /*Submit */ }
          
          <Button 
            action = {this.handleClearForm}
            type = {'secondary'}
            title = {'Clear'}
            style={buttonStyle}
          /> {/* Clear the form */}
          
        </form>
  
    );
  }
}

const buttonStyle = {
  margin : '10px 10px 10px 10px'
}

export default Container;